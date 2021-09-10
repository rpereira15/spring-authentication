package br.senac.spring.authentication.account;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

public interface UserAccountRepresentation {

    @Data
    @Getter
    @Setter
    @Builder(toBuilder = true)
    class UserAccountCreate {

        @NotNull
        @NotEmpty
        private String fullName;

        @NotNull
        @NotEmpty
        private String userName;

        @NotNull
        @NotEmpty
        private String password;

    }

    @Data
    @Getter
    @Setter
    @Builder(toBuilder = true)
    class UserAccountList {
        @NotNull
        @NotEmpty
        private Integer id;

        @NotNull
        @NotEmpty
        private String fullName;

        private static UserAccountList from(UserAccount userAccount) {
            return UserAccountList.builder()
                    .id(userAccount.getId())
                    .fullName(userAccount.getFullName())
                    .build();
        }

        public static List<UserAccountList> from(List<UserAccount> userAccounts) {
            return userAccounts.stream().map(UserAccountList::from).collect(Collectors.toList());
        }
    }


    @Data
    @Getter
    @Setter
    @Builder(toBuilder = true)
    class UserAccountDetails {

        @NotNull
        @NotEmpty
        private Integer id;

        @NotNull
        @NotEmpty
        private String fullName;

        @NotNull
        @NotEmpty
        private String userName;

        public static UserAccountDetails of(UserAccount userAccount) {

            return UserAccountDetails.builder()
                    .id(userAccount.getId())
                    .userName(userAccount.getUserName())
                    .fullName(userAccount.getFullName())
                    .build();
        }
    }
}
