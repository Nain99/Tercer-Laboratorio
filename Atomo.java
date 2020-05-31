package com.example.animacion;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;

/**
 * @author Nain_Perez
 * @version 30/05/2020 v1
 */
public class Atomo {

    private FloatBuffer bufVertices;
    private FloatBuffer bufVertices1;
    private FloatBuffer bufVerticesPunto;
    private int segmentos;
    private boolean llenado;
    private float VerticePunto[] = new float[]{
        0f,0f
    };

    public Atomo(float radio, int segmentos, boolean llenado) {
        this.segmentos = segmentos;
        this.llenado = llenado;

        ByteBuffer bufByte = ByteBuffer.allocateDirect(360 * 2 * 4);
        bufByte.order(ByteOrder.nativeOrder());
        bufVertices = bufByte.asFloatBuffer();

        ByteBuffer bufByte1 = ByteBuffer.allocateDirect(360 * 2 * 4);
        bufByte1.order(ByteOrder.nativeOrder());
        bufVertices1 = bufByte1.asFloatBuffer();

        ByteBuffer bufByte2 = ByteBuffer.allocateDirect(VerticePunto.length * 4);
        bufByte2.order(ByteOrder.nativeOrder()); // Utiliza el orden del byte nativo
        bufVerticesPunto = bufByte.asFloatBuffer(); // Convierte de byte a float
        bufVerticesPunto.put(VerticePunto);

        /* Lee los vértices (x,y) */
        int j = 0;
        int j1 = 0;
        float theta = 2 * 3.1415926f / 360f;
        float c = (float)Math.cos(theta);
        float s = (float)Math.sin(theta);
        float x = 1f;
        float y = 0f;
        for (float i = 0; i < 360.0f; i = i + 360.0f/segmentos) {
            bufVertices.put(j++, (float) Math.cos(Math.toRadians(i)) * radio);
            bufVertices.put(j++, (float) Math.sin(Math.toRadians(i)) * radio);
            bufVertices1.put(j1++,x);
            bufVertices1.put(j1++,y);
            float t = x;
            x = c * x - s * y;
            y = s * t + c * y;
        }

        bufVertices.rewind();
        bufVertices1.rewind();
        bufVerticesPunto.rewind();
    }
    public void dibujaProtonNeutron(GL10 gl) {
        /* Se habilita el acceso al arreglo de vértices */
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        /* Se especifica los datos del arreglo de vértices */
        gl.glVertexPointer(2, GL10.GL_FLOAT, 0, bufVertices);
        /* Renderiza las primitivas desde los datos del arreglo de vértices */
        gl.glDrawArrays((llenado) ? GL10.GL_TRIANGLE_FAN : GL10.GL_LINE_LOOP, 0, segmentos);
        /* Se deshabilita el acceso al arreglo de vértices */
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

    }
    public void dibujaOrbitaElectron(GL10 gl){
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glRotatef(75,1,0,0);
        gl.glVertexPointer(2,GL10.GL_FLOAT,0,bufVertices1);
        gl.glPointSize(2f);
        gl.glColor4f(1,0,0,1);
        gl.glDrawArrays(GL10.GL_POINTS,1,segmentos);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
    public void dibujaElectron(GL10 gl){
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(2, GL10.GL_FLOAT, 0, bufVerticesPunto);
        gl.glTranslatef(0.41f,0.41f,0);
        gl.glDrawArrays(GL10.GL_POINTS, 0, 1);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}
