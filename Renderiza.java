package com.example.animacion;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

/**
 * @author Nain_Perez
 * @version 30/05/2020 v1
 */
public class Renderiza implements Renderer {

    private Atomo atomo;
    private float angulo, incAngulo;
    private float angulo2, incAngulo2;
    private float angulo3, incAngulo3;
    private boolean v;

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {
        atomo = new Atomo(0.5f, 360, true);
        angulo = 60;
        incAngulo = 9;
        angulo2 = 140;
        incAngulo2 = 5;
        angulo3 = 270;
        incAngulo3 = 1;
        v =true;
        // Color de fondo
        gl.glClearColor(0, 0, 0, 0);
    }
    @Override
    public void onDrawFrame(GL10 gl) {
        /* Inicializa el buffer de color */
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        gl.glLoadIdentity();

        /*EJE  X,Y,Z*/
        /* RENDERIZA EL PROTON*/
        gl.glPushMatrix();
        gl.glScalef(1f, 1f, 0f);
        gl.glRotatef(angulo,1,1,1);

           /*RENDERIZA PROTRON*/
           gl.glPushMatrix();
           gl.glTranslatef(0.5f,0.5f,0);
           gl.glColor4f(7f/255f,7f/255f,158f/255f,0);
           atomo.dibujaProtonNeutron(gl);
           gl.glPopMatrix();

           /*RENDERIZA PROTRON*/
           gl.glPushMatrix();
           gl.glTranslatef(0.5f,-0.5f,0);
           gl.glColor4f(7f/255f,7f/255f,158f/255f,0);
           atomo.dibujaProtonNeutron(gl);
           gl.glPopMatrix();

           /*RENDERIZA NEUTRON*/
           gl.glPushMatrix();
           gl.glTranslatef(-0.3f,0.5f,0);
           gl.glColor4f(1,0,0,0);
           atomo.dibujaProtonNeutron(gl);
           gl.glPopMatrix();

           /*RENDERIZA NEUTRON*/
           gl.glPushMatrix();
           gl.glTranslatef(-0.5f,-0.5f,0);
           gl.glColor4f(1,0,0,0);
           atomo.dibujaProtonNeutron(gl);
           gl.glPopMatrix();

        gl.glColor4f(7f/255f,7f/255f,158f/255f, 0);
        atomo.dibujaProtonNeutron(gl);
        gl.glPopMatrix();

        /*EJE X,Y*/
        /*RENDERIZA PROTON*/
        gl.glPushMatrix();
        gl.glScalef(1f, 1f, 0f);
        gl.glRotatef(angulo2,1,1,0);

           /*RENDERIZA NEUTRON*/
           gl.glPushMatrix();
           gl.glTranslatef(0.5f,0.5f,0);
           gl.glColor4f(1,0,0,0);
           atomo.dibujaProtonNeutron(gl);
           gl.glPopMatrix();

           /*RENDERIZA NEUTRON*/
           gl.glPushMatrix();
           gl.glTranslatef(0.5f,-0.5f,0);
           gl.glColor4f(1,0,0,0);
           atomo.dibujaProtonNeutron(gl);
           gl.glPopMatrix();

           /*RENDERIZA NEUTRON*/
           gl.glPushMatrix();
           gl.glTranslatef(-0.3f,0.5f,0);
           gl.glColor4f(1,0,0,0);
           atomo.dibujaProtonNeutron(gl);
           gl.glPopMatrix();

           /*RENDERIZA PROTON*/
           gl.glPushMatrix();
           gl.glTranslatef(-0.5f,-0.5f,0);
           gl.glColor4f(7f/255f,7f/255f,158f/255f,0);
           atomo.dibujaProtonNeutron(gl);
           gl.glPopMatrix();

        gl.glColor4f(7f/255f,7f/255f,158f/255f, 0);
        atomo.dibujaProtonNeutron(gl);
        gl.glPopMatrix();

        /*EJE Y,Z*/
        /*RENDERIZA PROTON*/
        gl.glPushMatrix();
        gl.glScalef(1f, 1f, 0f);
        gl.glRotatef(angulo3,0,1,1);

            /*RENDERIZA PROTON*/
            gl.glPushMatrix();
            gl.glTranslatef(0.5f,0.5f,0);
            gl.glColor4f(7f/255f,7f/255f,158f/255f,0);
            atomo.dibujaProtonNeutron(gl);
            gl.glPopMatrix();

            /*RENDERIZA NEUTRON*/
            gl.glPushMatrix();
            gl.glTranslatef(0.5f,-0.5f,0);
            gl.glColor4f(1,0,0,0);
            atomo.dibujaProtonNeutron(gl);
            gl.glPopMatrix();

            /*RENDERIZA NEUTRON*/
            gl.glPushMatrix();
            gl.glTranslatef(-0.3f,0.5f,0);
            gl.glColor4f(1,0,0,0);
            atomo.dibujaProtonNeutron(gl);
            gl.glPopMatrix();

            /*RENDERIZA PROTON*/
            gl.glPushMatrix();
            gl.glTranslatef(-0.5f,-0.5f,0);
            gl.glColor4f(7f/255f,7f/255f,158f/255f,0);
            atomo.dibujaProtonNeutron(gl);
            gl.glPopMatrix();

        gl.glColor4f(7f/255f,7f/255f,158f/255f, 0);
        atomo.dibujaProtonNeutron(gl);
        gl.glPopMatrix();

        /*---------ORBITA DE LOS ELECTRONES---------*/

        /*RENDERIZA ORBITAS Y ELECTRONES; ANGULO*/
        gl.glPushMatrix();
        gl.glScalef(12,12,0);
        gl.glRotatef(angulo,0,1,0);
        gl.glColor4f(1,1,0,0);
        /*RENDERIZA ORBITA 1*/
        atomo.dibujaOrbitaElectron(gl);
            gl.glPushMatrix();
            gl.glPointSize(13f);
            gl.glColor4f(1,1,1,0);
            /*RENDERIZA ELECTRON 1*/
            atomo.dibujaElectron(gl);
            gl.glPopMatrix();
        /*RENDERIZA ORBITA 2*/
        atomo.dibujaOrbitaElectron(gl);
            gl.glPushMatrix();
            gl.glPointSize(13f);
            gl.glColor4f(0,1,1,0);
            /*RENDERIZA ELECTRON 2*/
            atomo.dibujaElectron(gl);
            gl.glPopMatrix();
        /*RENDERIZA ORBITA 3*/
        atomo.dibujaOrbitaElectron(gl);
           gl.glPushMatrix();
           gl.glPointSize(13f);
           gl.glColor4f(0,1,1,0);
           /*RENDERIZA ELECTRON 3*/
           atomo.dibujaElectron(gl);
           gl.glPopMatrix();
        gl.glPopMatrix();

        /*RENDERIZA ORBITAS Y ELECTRONES; ANGULO2*/
        gl.glPushMatrix();
        gl.glScalef(12,12,0);
        gl.glRotatef(-angulo2,0,1,0);
        /*RENDERIZA ORBITA 4*/
        atomo.dibujaOrbitaElectron(gl);
            gl.glPushMatrix();
            gl.glPointSize(13f);
            gl.glColor4f(0,1,1,0);
            /*RENDERIZA ELECTRON 4*/
            atomo.dibujaElectron(gl);
            gl.glPopMatrix();
        /*RENDERIZA ORBITA 5*/
        atomo.dibujaOrbitaElectron(gl);
            gl.glPushMatrix();
            gl.glPointSize(13f);
            gl.glColor4f(0,1,124f/255f,0);
            /*RENDERIZA ELECTRON 5*/
            atomo.dibujaElectron(gl);
            gl.glPopMatrix();
        /*RENDERIZA ORBITA 6*/    
        atomo.dibujaOrbitaElectron(gl);
            gl.glPushMatrix();
            gl.glPointSize(13f);
            gl.glColor4f(1,1,0,0);
            /*RENDERIZA ELECTRON 6*/
            atomo.dibujaElectron(gl);
            gl.glPopMatrix();
        gl.glPopMatrix();

        /*RENDERIZA ORBITAS Y ELECTRONES; ANGULO3*/
        gl.glPushMatrix();
        gl.glScalef(12f,12f,0);
        gl.glRotatef(angulo3,1,1,0);
        /*RENDERIZA ORBITA 7*/
        atomo.dibujaOrbitaElectron(gl);
            gl.glPushMatrix();
            gl.glPointSize(13f);
            gl.glColor4f(0,1,1,0);
            /*RENDERIZA ELECTRON 7*/
            atomo.dibujaElectron(gl);
            gl.glPopMatrix();
        /*RENDERIZA ORBITA 8*/
        atomo.dibujaOrbitaElectron(gl);
            gl.glPushMatrix();
            gl.glPointSize(13f);
            gl.glColor4f(143f/255f,1,0,0);
            /*RENDERIZA ELECTRON 8*/
            atomo.dibujaElectron(gl);
            gl.glPopMatrix();
        /*RENDERIZA ORBITA 9*/
        atomo.dibujaOrbitaElectron(gl);
            gl.glPushMatrix();
            gl.glPointSize(13f);
            /*RENDERIZA ELECTRON 9*/
            gl.glColor4f(255f/255f,0,31f/255f,0);
            atomo.dibujaElectron(gl);
            gl.glPopMatrix();
        gl.glPopMatrix();

        /*RENDERIZA ORBITAS Y ELECTRONES; ANGULO3*/
        gl.glPushMatrix();
        gl.glScalef(12f,12f,0);
        gl.glRotatef(-angulo3,1,1,0);
        /*RENDERIZA ORBITA 10*/
        atomo.dibujaOrbitaElectron(gl);
            gl.glPushMatrix();
            gl.glPointSize(13f);
            gl.glColor4f(0,1,1,0);
            /*RENDERIZA ELECTRON 10*/
            atomo.dibujaElectron(gl);
            gl.glPopMatrix();
        /*RENDERIZA ORBITA 11*/
        atomo.dibujaOrbitaElectron(gl);
            gl.glPushMatrix();
            gl.glPointSize(13f);
            gl.glColor4f(255f/255f,182f/255f,0,0);
            /*RENDERIZA ELECTRON 11*/
            atomo.dibujaElectron(gl);
            gl.glPopMatrix();
        /*RENDERIZA ORBITA 12*/
        atomo.dibujaOrbitaElectron(gl);
            gl.glPushMatrix();
            gl.glPointSize(13f);
            gl.glColor4f(116f/255f,255f/255f,240f/255f,0);
            /*RENDERIZA ELECTRON 12*/
            atomo.dibujaElectron(gl);
            gl.glPopMatrix();
        gl.glPopMatrix();

        /*RENDERIZA ORBITAS Y ELECTRONES; ANGULO2*/
        gl.glPushMatrix();
        gl.glScalef(12f,12f,0);
        gl.glRotatef(angulo2,1,1,1);
        /*RENDERIZA ORBITA 13*/
        atomo.dibujaOrbitaElectron(gl);
            gl.glPushMatrix();
            gl.glPointSize(13f);
            gl.glColor4f(149f/255f,11f/255f,105f/255f,0);
            /*RENDERIZA ELECTRON 13*/
            atomo.dibujaElectron(gl);
            gl.glPopMatrix();
        /*RENDERIZA ORBITA 14*/
        atomo.dibujaOrbitaElectron(gl);
           gl.glPushMatrix();
           gl.glPointSize(13f);
           gl.glColor4f(0,1,1,0);
           /*RENDERIZA ELECTRON 14*/
           atomo.dibujaElectron(gl);
           gl.glPopMatrix();
        /*RENDERIZA ORBITA 15*/
        atomo.dibujaOrbitaElectron(gl);
           gl.glPushMatrix();
           gl.glPointSize(13f);
           gl.glColor4f(0,0,1,0);
           /*RENDERIZA ELECTRON 15*/
           atomo.dibujaElectron(gl);
           gl.glPopMatrix();
        gl.glPopMatrix();

        /*RENDERIZA ORBITAS Y ELECTRONES; ANGULO*/
        gl.glPushMatrix();
        gl.glScalef(12f,12f,0);
        gl.glRotatef(-angulo,1,1,1);
        /*RENDERIZA ORBITA 16*/
        atomo.dibujaOrbitaElectron(gl);
            gl.glPushMatrix();
            gl.glPointSize(13f);
            gl.glColor4f(0,1,1,0);
            /*RENDERIZA ELECTRON 16*/
            atomo.dibujaElectron(gl);
            gl.glPopMatrix();
        /*RENDERIZA ORBITA 17*/
        atomo.dibujaOrbitaElectron(gl);
            gl.glPushMatrix();
            gl.glPointSize(13f);
            gl.glColor4f(0,1,1,0);
            /*RENDERIZA ELECTRON 17*/
            atomo.dibujaElectron(gl);
            gl.glPopMatrix();
        /*RENDERIZA ORBITA 18*/
        atomo.dibujaOrbitaElectron(gl);
            gl.glPushMatrix();
            gl.glPointSize(13f);
            gl.glColor4f(0,1,0,0);
            /*RENDERIZA ELECTRON 18*/
            atomo.dibujaElectron(gl);
            gl.glPopMatrix();

            gl.glPushMatrix();
            gl.glPointSize(13f);
            gl.glColor4f(1,0,232f/255f,0);
            /*RENDERIZA ELECTRON 19*/
            atomo.dibujaElectron(gl);
            gl.glPopMatrix();
        gl.glPopMatrix();

        angulo = angulo + incAngulo;
        if ( angulo > 360) {
            angulo = angulo - 360;
        }
        angulo2 = angulo2 + incAngulo2;
        if ( angulo2 > 360) {
            angulo2 = angulo2 - 360;
        }
        angulo3 = angulo3 + incAngulo3;
        if ( angulo3 > 360) {
            angulo3 = angulo3 - 360;
        }
    }
    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU.gluOrtho2D(gl, -13, 13, -20, 20);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }
}