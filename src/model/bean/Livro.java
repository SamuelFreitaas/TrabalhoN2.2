package model.bean;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int paginas;
    private double preco;
    private String categoria;
    private boolean status;
    private int ISBN;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public double getPreco() {
        return preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean isStatus() {
        return status;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Livro{" + "id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", paginas=" + paginas + ", preco=" + preco + ", categoria=" + categoria + ", status=" + status + ", ISBN=" + ISBN + '}';
    }
    
    
    
    
    
}
