package org.example.springbe.user;

import lombok.RequiredArgsConstructor;
import org.example.springbe.user.model.AuthUserDetails;
import org.example.springbe.user.model.User;
import org.example.springbe.user.model.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDto.SignupRes signup(UserDto.SignupReq dto) {
        User user = dto.toEntity();
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);

        return UserDto.SignupRes.from(user);
    }

//    public UserDto.LoginRes login(UserDto.LoginReq dto) {
//        User user = userRepository.findByEmail(dto.getEmail())
//                .orElseThrow(() -> new IllegalArgumentException("이메일이나 비밀번호가 틀림"));
//        if (!user.getPassword().equals(dto.getPassword())) {
//            throw new IllegalArgumentException("이메일이나 비밀번호가 틀림");
//        }
//        return UserDto.LoginRes.from(user);
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow();
        return AuthUserDetails.from(user);
    }
}
