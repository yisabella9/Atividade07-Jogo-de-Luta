public class LutadorPesado extends Lutador {

    public LutadorPesado(String nome) {
        super(nome, 130, 100, 20);
    }

    @Override
    public void atacar(Lutador oponente) {
        int dano = forca;
        System.out.println(nome + " (Pesado) atacou causando " + dano + " de dano!");
        oponente.receberDano(dano);
    }

    @Override
    public void especial(Lutador oponente) {
        if (energia >= 40) {
            int dano = 50;
            energia -= 40;
            System.out.println(nome + " usou ataque ESPECIAL (Pesado) causando " + dano + " de dano!");
            oponente.receberDano(dano);
        } else {
            System.out.println(nome + " não tem energia suficiente!");
        }
    }
}
