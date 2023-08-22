package com.ofss.services;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ofss.repository.FundRepository;
import com.ofss.repository.InvestmentRepository;
import com.ofss.repository.InvestorRepository;
import com.ofss.repository.TransactionRepository;
import com.ofss.utility.Calculate;

import oracle.net.aso.f;

import com.ofss.model.*;
import com.ofss.pojo.TransactionPOJO;
@Service
public class InvestorService {
	@Autowired
	InvestmentRepository investmentRepository;

	@Autowired
	FundRepository fundRepository;
	
	@Autowired
	InvestorRepository investorRepository;
	
	@Autowired
	FundService fundserive;
	
	@Autowired
	TransactionRepository trandRepo;
	
	public Boolean login(Investor investor){
		Investor tempUser = investorRepository.findByInvestorNamePass(investor.getUsername(), investor.getPassword());
		System.out.println(tempUser.getUsername()+"   "+investor.getUsername());
		
		if(( tempUser.getUsername().equals(investor.getUsername()) ) && ( tempUser.getPassword().equals(investor.getPassword()) )) {
			
			System.out.println("Logged in ");
//			return "Investor Logged in";
			//return "redirect:/dashboard";
			return true;

		}
		else {
			System.out.println("Invalid User");
//			return "invalid User";
			return false;
		}
	}
	
	@Transactional
	public String buy(TransactionPOJO transactionpojo) {
		
		 Investor investor = investorRepository.findOne(transactionpojo.getInvestorId());
	     MutualFund mutualFund = fundRepository.findOne(transactionpojo.getMutualFundId());
	     
	     if(transactionpojo.getTransactionAmount() == 0)
	     {
	    	 return "Enter the transaction amount";
	     }
	     else if (investor != null && mutualFund != null) {
	    	 double  currentNav = mutualFund.getNav();
	    	 double entryLoad = mutualFund.getEntryLoad();
	            // Calculate units to buy after considering entry load
	            //double unitsToBuy = calculateUnitsToBuy(investmentAmount, currentNav, entryLoad);
	    	 double total_units =Calculate.UnitsToBuys(transactionpojo.getTransactionAmount(), fundRepository.findNavOfMutualFund(transactionpojo.getMutualFundId()),mutualFund.getEntryLoad());

	            // Update investor holdings
	            Investment investment = investmentRepository.findByInvestorAndMutualFund(investor,mutualFund);
	            if (investment != null) {
	        		investorRepository.updateInvestment((investment.getTotalUnits()+total_units), transactionpojo.getInvestorId(), transactionpojo.getMutualFundId());
	            } else {
	        		investorRepository.setInvestment(total_units, transactionpojo.getInvestorId(), transactionpojo.getMutualFundId());
	            }
	            // Update the corpus amount and NAV of the mutual fund
	            fundserive.updateMutualFundDetailsForBuy(mutualFund, total_units, transactionpojo.getTransactionAmount());
	            // Record the transaction in transaction history
	    		trandRepo.buyTransaction(transactionpojo.getTransactionAmount(), total_units, transactionpojo.getInvestorId(), transactionpojo.getMutualFundId());
//	            TransactionHistory transactionHistory = new TransactionHistory(user, mutualFund,"Buy", unitsToBuy, investmentAmount, new Date());
//	            transactionHistoryRepository.save(transactionHistory);
	        } else {
	            return "User or mutual fund not found.";
	        }
		

		return "mutual fund bought";
	}
	@Transactional
	public String Sell(TransactionPOJO transactionpojo) {
		
		 // Retrieve user and mutual fund, check their validity
        Investor investor = investorRepository.findOne(transactionpojo.getInvestorId());
        MutualFund mutualFund = fundRepository.findOne(transactionpojo.getMutualFundId());
        Double exitLoad = mutualFund.getExit_load();
        if (investor != null && mutualFund != null) {
        	
            // Check if the user holds units of the mutual fund
            Investment investment = investmentRepository.findByInvestorAndMutualFund(investor,mutualFund);
            if (investment != null) {
                double currentNav = mutualFund.getNav();
                double currentCorpusAmount = mutualFund.getTotalInvestment();
                
                // Calculate the actual units to be sold after considering the exit load
                Double unitsToSell = Calculate.UnitsToSell(transactionpojo.getTransactionAmount(), currentNav, exitLoad);
                
                if (investment.getTotalUnits() >= unitsToSell) {
                	
                    // Update user's holdings
                	double newunits = investment.getTotalUnits() - unitsToSell;
                	investment.setTotalUnits(newunits);
                	investmentRepository.save(investment);
                	
                    // Update the corpus amount and NAV of the mutual fund
    	            fundserive.updateMutualFundDetailsForSell(mutualFund, unitsToSell, transactionpojo.getTransactionAmount());
                    // Record the sale transaction
    	    		trandRepo.sellTransaction(transactionpojo.getTransactionAmount(), newunits, transactionpojo.getInvestorId(), transactionpojo.getMutualFundId());

                } else {
                    return "User does not hold sufficient units for sale.";
                }
            } else {
            	 return  "User does not hold units of this mutual fund.";
            }
        } else {
        	 return "User or mutual fund not found.";
        }
		
		
		//investment.setInvestorId(transactionpojo.getInvestorId());
//		investment.setMutualFundId();
//		investment.set
		return "mutual fund sold";
	}
//	
	
	
}
