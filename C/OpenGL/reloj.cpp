#include <iostream>
#include <cmath>
#include <Utilidades.h>
#include <math.h>
#include <time.h>
#include <stdio.h>
#include <stdlib.h>

static float alfa = 0;
struct tm *newtime;
time_t ltime;

#define tasaFPS 30

void Sprint( int x, int y, char *st)
{
	int l,i;

	l=strlen( st );
	glRasterPos3i( x, y, -1);
	for( i=0; i < l; i++)
		{
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, st[i]);
	}

}

void init()
{
    glEnable(GL_DEPTH_TEST);
    glEnable(GL_LIGHTING);
    glEnable(GL_LIGHT0);
    glEnable(GL_COLOR_MATERIAL);
}

void display()
{
	
	int varilla_horas , varilla_sec;
	time(&ltime); // Obtenemos tiempo
	newtime = localtime(&ltime); // convertimos a hora local

	glClearColor(1,1,1,1);
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

	//Ponemos texto en la pantalla.
	glMatrixMode (GL_PROJECTION);
	glLoadIdentity();
	glOrtho(-8.0, 8.0, -8.0, 8.0, 1.0, 60.0);
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
	glDisable(GL_LIGHTING);
	glDisable(GL_COLOR_MATERIAL);

	// Color de las letras
	glColor3f( 0, 0, 0);
 	Sprint(-3,-2, asctime(newtime));

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    GLint viewport[4];
    glGetIntegerv(GL_VIEWPORT, viewport);
    double aspect = (double)viewport[2] / (double)viewport[3];
    gluPerspective(60, aspect, 1, 100);

    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();

    // movemos hacia atrás un poco
    glTranslatef( 0, 0, -1 );
	gluLookAt(0,0,1,0,0,0, 0,1,0);

	glPushMatrix();
		//glColor3ub(0,0,255);
		glRotatef( 180, 1.0, 0.0, 0.0);
		//glutWireSphere(1,15,15);
	
	// varilla horas
	glPushMatrix();
	glColor3f(1.0, 0.5, 0.5);
	glTranslatef( 0, 0, 0.0);
	glRotatef( (360/12) * newtime->tm_hour+ (360/60) * (60 / (newtime->tm_min+1)), 0.0, 0.0, 1.0);
	glPushMatrix();
	glTranslatef(0.0, 0.0, 2.0);

	glPopMatrix();
	glRotatef( 90, 1.0, 0.0, 0.0);
	glutSolidCone(0.025,0.5, 6, 16);
	glPopMatrix();

	// varilla minutos
	glPushMatrix();
	glColor3f(1.0, 0.5, 1.0);
	glTranslatef( 0, 0, 0.0);
	glRotatef( (360/60) * newtime->tm_min, 0.0, 0.0, 1.0);
	glPushMatrix();
	glTranslatef(0.0, 0.0, 3.0);
	glScalef(0.5, 0.5, 1.0);

	glPopMatrix();
	glRotatef( 90, 1.0, 0.0, 0.0);
	glutSolidCone(0.025,0.6, 6, 16);
	glPopMatrix();

	// varilla de los segundos
	glPushMatrix();
	glColor3f(1.0, 0.0, 0.5);
	glTranslatef( 0, 0, -0.0);
	glRotatef( (360/60) * newtime->tm_sec, 0.0, 0.0, 1.0);

	glPushMatrix();
	glTranslatef(0.0, 0.0, 4.0);
	glScalef(0.25, 0.25, 1.0);

	glPopMatrix();
	glRotatef( 90, 1.0, 0.0, 0.0);
	glutSolidCone(0.025,0.8, 6, 16);
	glPopMatrix();


	//Dibujamos las marcas de las horas
	for(varilla_horas = 0; varilla_horas < 12; varilla_horas++){

		glPushMatrix();
		glColor3f(0, 1, 0); 
		glTranslatef(0.0, 0.0, 0.0);
		glRotatef( (360/12) * varilla_horas, 0.0, 0.0, 1.0);
		glTranslatef( 0.9, 0.0, 0.0);
		glRotatef(-180,1,0,0);
		glutSolidCone(0.05,0.4, 6, 16);
		glPopMatrix();
	}
	//Dibujamos las marcas de los segundos
	for(varilla_sec = 0; varilla_sec < 60; varilla_sec++){

		glPushMatrix();
		glColor3f(0, 0, 1);
		glTranslatef(0.0, 0.0, 0.0);
		glRotatef( (360/60) * varilla_sec, 0.0, 0.0, 1.0);
		glTranslatef(0.9, 0.0, 0.0);
		glutSolidCube(0.03);
		glPopMatrix();

	}

	glPushMatrix();
        glTranslatef(0,0,0);
        glRotatef(alfa, 0.1, 0.2, 0.5);
        glColor3ub(255,0,255);
        glutWireCube(0.15);
    glPopMatrix();

	glPopMatrix();

	
    glutSwapBuffers();
}

void reshape(GLint w, GLint h)
{
    // Ajusto el marco a la totalidad del area de dinujo
    glViewport( 0, 0,w,h);
    //Activar la transformacion Projection
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    //Ajuste de la razon de aspecto de la foto a la razon del marco
    float razon = (float)w/h;
   
    gluPerspective(2*asin(1/sqrt(0.5*0.5 + 2*2 + 2*2)) * 180 / 3.1415926, razon, 1, 10);
}

void update()
{

	static const float omega = 60;
	// Pido la hora por primera vez
	static int hora_anterior = glutGet(GLUT_ELAPSED_TIME);

	int hora_actual = glutGet(GLUT_ELAPSED_TIME);

	// Tiempo transcurrido en msg
	float tiempo_transcurrido = hora_actual - hora_anterior;
	
	alfa += omega * tiempo_transcurrido/1000.0;
	
	// Actualizar hora_anterior a la hora_actual
	hora_anterior = hora_actual;

	glutPostRedisplay();	// Encola un evento de display
}

int main(int argc, char **argv)
{
    glutInit(&argc, argv);
    glutInitWindowSize(600,600);
    glutInitDisplayMode(GLUT_RGBA | GLUT_DEPTH | GLUT_DOUBLE);
    glutCreateWindow("Reloj Analogico");

    glutDisplayFunc(display);
    glutReshapeFunc(reshape);
	glutIdleFunc(update);

    init();

    glutMainLoop();
    
}