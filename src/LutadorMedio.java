public class LutadorMedio extends Lutador {

    public LutadorMedio(String nome) {
        super(nome, 100, 100, 15);
    }

    @Override
    public void atacar(Lutador oponente) {
        int dano = forca;
        System.out.println(nome + " (Médio) atacou causando " + dano + " de dano!");
        oponente.receberDano(dano);
    }

    @Override
    public void especial(Lutador oponente) {
        if (energia >= 30) {
            int dano = 35;
            energia -= 30;
            System.out.println(nome + " usou ataque ESPECIAL (Médio) causando " + dano + " de dano!");
            oponente.receberDano(dano);
        } else {
            System.out.println(nome + " não tem energia suficiente!");
        }
    }
}

