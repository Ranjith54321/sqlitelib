package dot.ranjith.sqlitelib;

    public class User {
        private String BookName;
        private String AuthorName;
        private String Avail;

        public User(String bName,String aName, String avail){
            BookName = bName;
            AuthorName = aName;
            Avail = avail;
        }

        public String getBookName() {
            return BookName;
        }

        public void setBookName(String firstName) {
            BookName = BookName;
        }

        public String getAuthorName() {
            return AuthorName;
        }

        public void setAuthorName(String lastName) {
            AuthorName = AuthorName;
        }

        public String getAvailable() {
            return Avail;
        }

        public void setAvailable(String favFood) {
            Avail = Avail;
        }
    }
