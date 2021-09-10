package br.senac.spring.authentication.account;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserAccount save(UserAccountRepresentation.UserAccountCreate userAccountCreate) {
        return this.userAccountRepository.save(UserAccount.builder()
                .fullName(userAccountCreate.getFullName())
                .userName(userAccountCreate.getUserName())
                .password(this.bCryptPasswordEncoder.encode(userAccountCreate.getPassword()))
                .build());
    }
}
