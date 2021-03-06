package jaefactory.community.service;

import jaefactory.community.domain.user.User;
import jaefactory.community.domain.user.UserRepository;
import jaefactory.community.dto.UserProfileDto;
import jaefactory.community.handler.exception.CustomValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional(readOnly = true)
    public UserProfileDto userProfile(long pageUserId, long principalId) {
        UserProfileDto dto = new UserProfileDto();

        User userEntity = userRepository.findById(pageUserId).get();

        dto.setUser(userEntity);
        dto.setPageOwnerState(pageUserId == principalId);

        return dto;
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserById(long id){
        return userRepository.findById(id);
    }
}
