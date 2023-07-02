package com.poprev.web.controller.token;

import com.poprev.service.dto.PurchaseTokenDto;
import com.poprev.service.exception.PoprevException;
import com.poprev.service.response.TransactionResponse;
import com.poprev.service.token.TokenServiceImplementation;
import com.poprev.web.response.ResponseDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/tokens")
public class TokenController {

    @Autowired
    TokenServiceImplementation tokenServiceImpl;

    @PostMapping("")
    public ResponseEntity<?> purchaseToken(@Valid @RequestBody PurchaseTokenDto dto) throws PoprevException {
        tokenServiceImpl.buyToken(dto);
        ResponseDetails responseDetails = new ResponseDetails(LocalDateTime.now(), "Token purchased!", "success");
        return new ResponseEntity<>(responseDetails, HttpStatus.OK);
    }

    @GetMapping("/transactions/{tokenId}")
    public ResponseEntity<?> findAllTransactionsOfAToken(@PathVariable Long tokenId) throws PoprevException {
        TransactionResponse response = tokenServiceImpl.findAllTransactionsOfAToken(tokenId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
