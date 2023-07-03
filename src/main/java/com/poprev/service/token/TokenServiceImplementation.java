package com.poprev.service.token;

import com.poprev.data.model.investment.Investment;
import com.poprev.data.model.token.Token;
import com.poprev.data.model.transaction.Transaction;
import com.poprev.data.model.transaction.TransactionStatus;
import com.poprev.data.model.transaction.TransactionType;
import com.poprev.data.model.user.PoprevUser;
import com.poprev.data.repository.investment.InvestmentRepository;
import com.poprev.data.repository.project.ProjectRepository;
import com.poprev.data.repository.token.TokenRepository;
import com.poprev.data.repository.transaction.TransactionRepository;
import com.poprev.data.repository.user.PoprevUserRepository;
import com.poprev.service.dto.PurchaseTokenDto;
import com.poprev.service.exception.PoprevException;
import com.poprev.service.response.InvestmentResponse;
import com.poprev.service.response.TransactionResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TokenServiceImplementation implements TokenService {

    @Autowired
    TokenRepository tokenRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    PoprevUserRepository userRepository;
    @Autowired
    InvestmentRepository investmentRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    private Token findTokenById(Long id) throws PoprevException {
        return tokenRepository.findById(id)
                .orElseThrow(() -> new PoprevException("token not found"));
    }

    private PoprevUser findUserById(Long id) throws PoprevException {
        return userRepository.findById(id)
                .orElseThrow(() -> new PoprevException("user not found"));
    }

    //Buy/Sell tokens
    @Override
    public void buyToken(PurchaseTokenDto dto) throws PoprevException {
        Token token = findTokenById(dto.getTokenId());
        PoprevUser user = findUserById(dto.getUserId());

        Transaction transaction = Transaction.builder()
                .transactionStatus(TransactionStatus.valueOf(dto.getTransactionStatus()))
                .transactionReference(dto.getTransactionReference())
                .transactionType(TransactionType.PURCHASE)
                .transactionAmount(dto.getAmountPaid())
                .transactionDate(LocalDateTime.now())
                .token(token)
                .user(user)
                .build();
        transactionRepository.save(transaction);
    }

    //Show transactions relating to a token
    @Override
    public TransactionResponse findAllTransactionsOfAToken(Long tokenId) {
        List<Transaction> transactions = transactionRepository.findAllByToken_Id(tokenId);
        return TransactionResponse.builder()
                .totalNoOfTransactions(transactions.size())
                .transactions(transactions)
                .build();
    }

    //Show a user the details of their investment in a token
    @Override
    public Investment findUserInvestmentDetails(Long investmentId, Long userId) throws PoprevException {
        return investmentRepository.findByIdAndUser_Id(investmentId, userId)
                .orElseThrow(() -> new PoprevException("Could not find investment"));
    }

    @Override
    public InvestmentResponse findAllUserInvestmentInAToken(Long userId, Long tokenId) {
        List<Investment> investments = investmentRepository.findAllByUser_IdAndToken_Id(userId, tokenId);
        return InvestmentResponse.builder()
                .totalNoOfInvestments(investments.size())
                .investments(investments)
                .build();
    }


}
