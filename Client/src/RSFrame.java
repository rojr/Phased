// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.awt.*;

final class RSFrame extends Frame {

    private final RSApplet rsApplet;

    public RSFrame(RSApplet RSApplet_, int i, int j) {
        rsApplet = RSApplet_;
        setTitle("Aggroth by Shaloxis!");
        setResizable(true);
        setVisible(true);
        toFront();
        setSize(i + 8, j + 30); //24
    }

    public Graphics getGraphics() {
        Graphics g = super.getGraphics();
        g.translate(4, 24);
        return g;
    }

    public void update(Graphics g) {
        rsApplet.update(g);
    }

    public void paint(Graphics g) {
        rsApplet.paint(g);
    }
}

