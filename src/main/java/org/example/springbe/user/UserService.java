package org.example.springbe.user;

import lombok.RequiredArgsConstructor;
import org.example.springbe.user.model.User;
import org.example.springbe.user.model.UserDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void signup(UserDto.SignupReq dto) {
        User user = dto.toEntity();
        userRepository.save(user);
    }

    public UserDto.LoginRes login(UserDto.LoginReq dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("이메일이나 비밀번호가 틀림"));
        if (!user.getPassword().equals(dto.getPassword())) {
            throw new IllegalArgumentException("이메일이나 비밀번호가 틀림");
        }
        return UserDto.LoginRes.from(user);
    }

}
