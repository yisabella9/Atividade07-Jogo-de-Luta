public class LutadorLeve extends Lutador {

    public LutadorLeve(String nome) {
        super(nome, 80, 100, 10);
    }

    @Override
    public void atacar(Lutador oponente) {
        int dano = forca;
        System.out.println(nome + " (Leve) atacou causando " + dano + " de dano!");
        oponente.receberDano(dano);
    }

    @Override
    public void especial(Lutador oponente) {
        if (energia >= 25) {
            int dano = 25;
            energia -= 25;
            System.out.println(nome + " usou ataque ESPECIAL (Leve) causando " + dano + " de dano!");
            oponente.receberDano(dano);
        } else {
            System.out.println(nome + " não tem energia suficiente!");
        }
    }
}