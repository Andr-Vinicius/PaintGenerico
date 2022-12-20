package paint;

import java.awt.Graphics2D;

/**
 *
 * @author vinicius
 */
public abstract class Forma {
    // É abstrata, pois não instanciaremos formas e sim classes que a herdam
    
    // De private pra protected, para (somente) as classes que a herdem
    //possam acessar essas variáveis
    protected int xi;
    protected int yi;
    protected int xf;
    protected int yf;
    
    // Responsabilidade de desenho é da Classe e não do painel de componentes
    public abstract void desenhar(Graphics2D g2d); // Não tem implementação aqui

    public int getXi() {
        return xi;
    }

    public void setXi(int xi) {
        this.xi = xi;
    }

    public int getYi() {
        return yi;
    }

    public void setYi(int yi) {
        this.yi = yi;
    }

    public int getXf() {
        return xf;
    }

    public void setXf(int xf) {
        this.xf = xf;
    }

    public int getYf() {
        return yf;
    }

    public void setYf(int yf) {
        this.yf = yf;
    }
}
