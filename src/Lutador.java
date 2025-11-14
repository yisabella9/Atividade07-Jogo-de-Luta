public abstract class Lutador {
    protected String nome;
    protected int vida;
    protected int energia;
    protected int forca;

    public Lutador(String nome, int vida, int energia, int forca) {
        this.nome = nome;
        this.vida = vida;
        this.energia = energia;
        this.forca = forca;
    }

    public abstract void atacar(Lutador oponente);
    public abstract void especial(Lutador oponente);


    public void defender() {
        System.out.println(nome + " está defendendo e recuperou 10 de energia!");
        energia += 10;
        if (energia > 100) energia = 100;
    }

    public void MostrarStatus() {
        System.out.println("======== STATUS ========");
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vida);
        System.out.println("Energia: " + energia);
        System.out.println("========================");
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void receberDano(int dano) {
        vida -= dano;
        if (vida < 0) vida = 0;
    }

    public void curar(int pontos) {
        vida += pontos;
        if (vida > 100) vida = 100;
        System.out.println(nome + " recuperou" + pontos + " de vida!");
    }
}



