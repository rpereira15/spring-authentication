package br.senac.spring.authentication.account;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

    private UserAccountService userAccountService;

    @PostMapping
    @RequestMapping("/user")
    public ResponseEntity<UserAccountRepresentation.UserAccountDetails> createAccount(
            @RequestBody UserAccountRepresentation.UserAccountCreate userAccount) {

        return ResponseEntity.ok(UserAccountRepresentation.UserAccountDetails.of(this.userAccountService.save(userAccount)));
    }
}
