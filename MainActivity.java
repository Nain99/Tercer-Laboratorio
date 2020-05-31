package com.example.animacion;

import android.os.Bundle;
import android.opengl.GLSurfaceView;
import android.app.Activity;

/**
 * @author Nain_Perez
 * @version 30/05/2020 v1
 */

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* Se crea el objeto GLSurfaceView */
        GLSurfaceView superficie = new GLSurfaceView(this);
        /* Se crea el objeto Renderiza */
        Renderiza renderiza = new Renderiza();
        /* GLSurfaceView <- Renderiza : Inicia el renderizado */
        superficie.setRenderer(renderiza);
         /* Activity <- GLSurfaceView : Coloca la Vista de la Superficie del
         * OpenGL como un Contexto de ésta Actividad.*/
        setContentView(superficie);
    }
}
