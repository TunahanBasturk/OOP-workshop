
public class BookService {
    private Book[] books;
    private int bookCount;
    public BookService(){
        this.books = new Book[100];
        this.bookCount = 0;
    }

    public void addBook(Book book){
        books[bookCount] = book;
        bookCount++;
    }
    public void deleteBook(int bookId){
        for (int i=0; i<bookCount;i++){
            if(books[i].getId()==bookId){
                for (int j=i;j<bookCount-1;j++){
                    books[j]=books[j+1];
                }
                bookCount--;
                break;
            }
        }
    }
    public Book getBookById(int bookId){
        for (int i=0; i<bookCount;i++) {
            if (books[i].getId()==bookId){
                return books[i];
            }
        }
        return null;
    }
    public Book getBooksByAuthorName (String authorName){
        for (int i=0; i<bookCount;i++){
            if (books[i].getAuthorName()==authorName){
                return books[i];
            }
        }
        return null;
    }

    public void updateBook(Book book,int id){
        boolean isBookFound = false;
        for(int i=0;i<bookCount;i++){
            if(books[i].getId()==id){
                book.setId(books[i].getId());
                book.setPage(books[i].getPage());
                books[i] = book;
                isBookFound = true;
                break;
            }
        }

        if(isBookFound){
            System.out.println("Kitap gucellenmistir...");
        }else {
            System.out.println("Kitap bulunamadi...");
        }

    }
    public Book[] getBooks(){
        return books;
    }

    // delete
    // getBookById
    // getBooksByAuthorName
}
