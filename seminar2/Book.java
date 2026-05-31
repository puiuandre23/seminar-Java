package seminar2;

public class Book {
    private String titlu;
    private String autor;
    private double pret;

    public Book() {}

    public Book(String titlu, String autor, double pret) {
        this.titlu = titlu;
        this.autor = autor;
        this.pret = pret;
    }

    public String getTitlu() { return titlu; }

    public void setTitlu(String titlu) { this.titlu = titlu; }

    public String getAutor() { return autor; }

    public void setAutor(String autor) { this.autor = autor; }

    public double getPret() { return pret; }

    public void setPret(double pret) { this.pret = pret; }

    @Override
    public String toString() {
        return "Book{" +
                "titlu='" + titlu + '\'' +
                ", autor='" + autor + '\'' +
                ", pret=" + pret +
                '}';
    }
}
