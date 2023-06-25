public class UserUseCase {
    private final IUserRepository repository;

    public UserUseCase(IUserRepository repository) {
        this.repository = repository;
    }

    public User createUser(CreateUserRequest request) throws UserCreationException {
        User user = new User(request.getUsername(), request.getEmail());
        // do any additional business logic validation here
        repository.save(user);
        return user;
    }

    public User getUser(int userId) throws UserNotFoundException {
        User user = repository.get(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }
        return user;
    }

    public User updateUser(int userId, UpdateUserRequest request) throws UserNotFoundException {
        User user = repository.get(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }
        // do any additional business logic validation here
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        repository.save(user);
        return user;
    }

    public void deleteUser(int userId) throws UserNotFoundException {
        User user = repository.get(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }
        repository.delete(userId);
    }
}