import java.util.List;

public class UserService {

    private final BookService bookService;

    private User[] users;
    private int userCount;
    public UserService(BookService bookService){
        this.bookService = bookService;
        this.users = new User[100];
        this.userCount = 0;
    }

    public void addUser(User user){
        users[userCount] = user;
        userCount++;
    }
    public void deleteUser(int userId){
        for (int i=0; i<userCount;i++){
            if (users[i].getId()==userId){
                for (int j=i;j<userCount-1;j++){
                    users[j]=users[j+1];
                }
                userCount--;
                break;
            }
        }
    }
    public User getUserByTc(String tcNo){
        for (int i=0;i<userCount;i++){
            if (users[i].getTc() == tcNo){
               return users[i];
            }
        }
        return null;
    }
    public void updateUser(int userId,User updatedUser){
        for(int i=0;i<userCount;i++){
            if (users[i].getId()==userId){
                users[i]=updatedUser;
                break;
            }
        }
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

// Delete, Update, getUserBYTC, assignBookToUser methodlariniz yaziniz.
}
