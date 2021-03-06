package Test_paquete;

import java.util.ArrayList;
import java.util.Date;

import modelo.Cliente;
import modelo.Colaborador;
import modelo.Servicio;

import modelo.Tarea;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

public class ColaboradorTest1
{
    ColaboradorTestFixture1 fixture1= new ColaboradorTestFixture1();
    public ColaboradorTest1()
    {
    }

    public static void main(String[] args)
    {
        String[] args2 = { ColaboradorTest1.class.getName() };
        JUnitCore.main(args2);
    }

    @Before
    public void setUp() throws Exception
    {
        this.fixture1.setUp();
    }

    @After
    public void tearDown() throws Exception
    {
        this.fixture1.tearDown();
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {
    }

    /**
     * @see modelo.Colaborador#crearTarea(modelo.Servicio,modelo.Cliente)
     */
    @Test
    public void testCrearTarea1()
    {
        try
        {
            int size=this.fixture1.colab2.getTareas().size();
            this.fixture1.colab2.crearTarea(new Servicio("Limpiar","tipoA",52),new Cliente("Juan","juan@gmail.com","4324234","2121321312","123","grupo1"));
            assertTrue("No se agreg� la tarea",size+1==this.fixture1.colab2.getTareas().size());
        }
        catch(final Exception e)
        {
            fail("Crear una tarea nueva dispara excepcion");
        }
    }
    

    /**
     * @see modelo.Colaborador#eliminarTarea(modelo.Tarea)
     */
    @Test
    public void testEliminarTarea1()
    {
        try
        {
            int size=this.fixture1.colab.getTareas().size();
            ArrayList<Tarea> t = new ArrayList<Tarea>(fixture1.colab.getTareas().values());
            fixture1.colab.eliminarTarea(t.get(3));
            assertTrue("No se elimino la tarea",size-1==this.fixture1.colab.getTareas().size());
        }
        catch(final Exception e)
        {
            fail("Fallo inesperado");
        }
    }
    
    /**
     * @see modelo.Colaborador#cerrarTarea(modelo.Tarea)
     */
    @Test
    public void testCerrarTarea1()
    {
        try
        {
            this.fixture1.colab.cerrarTarea(this.fixture1.tareas.get(0));
            assertTrue("La tarea no fue cerrada",this.fixture1.colab.getTareas().get(fixture1.tareas.get(0).getCliente()).getEstado().devolverestado().equalsIgnoreCase("cerrada"));
        }
        catch(final Exception e)
        {
            fail("Error inesperado");
        }
    }
    
    /**
     * @see modelo.Colaborador#cerrarTarea(modelo.Tarea)
     */
    @Test
    public void testCerrarTarea2()
    {
        try
        {
            this.fixture1.colab.cerrarTarea(fixture1.tareas.get(3));
            fail("No se chequea que la tarea este cerrada");
        }
        catch(final Exception e)
        {
            fail("Se lanza excepcion pues se intenta cerrar una tarea cerrada");
        }
    }

    /**
     * @see modelo.Colaborador#pausarTarea(modelo.Tarea)
     */
    @Test
    public void testPausarTarea1()
    {
        try
        {
            this.fixture1.colab.pausarTarea(fixture1.colab.getTareas().get(this.fixture1.bdd.getClientes().get(4)));
            assertTrue("La tarea no esta pausada",fixture1.colab.getTareas().get(this.fixture1.bdd.getClientes().get(4)).getEstado().devolverestado().equalsIgnoreCase("pausada"));
        }
        catch(final Exception e)
        {
            //fail("No se verifica que este pausada");
        }
    }
    
    /**
     * @see modelo.Colaborador#pausarTarea(modelo.Tarea)
     */
    @Test
    public void testPausarTarea2()
    {
        try
        {
            ArrayList<Tarea> aux=new ArrayList<Tarea>(this.fixture1.colab2.getTareas().values());
            this.fixture1.colab2.pausarTarea(aux.get(0));
            assertTrue("No se verifica que ya este pausada",aux.get(0).getEstado().devolverestado().equalsIgnoreCase("pausada"));
        }
        catch(final Exception e)
        {
            fail("Lanza excepcion al pausar una tarea ya pausada");
        }
    }
    
    /**
     * @see modelo.Colaborador#pausarTarea(modelo.Tarea)
     */
    @Test
    public void testPausarTarea3()
    {
        try
        {
            ArrayList<Tarea> aux=new ArrayList<Tarea>(this.fixture1.colab.getTareas().values());
            this.fixture1.colab.pausarTarea(aux.get(0));
            assertTrue("No se verifica que ya este cerrada",aux.get(1).getEstado().devolverestado().equalsIgnoreCase("cerrada"));
        }
        catch(final Exception e)
        {
            fail("Lanza excepcion al pausar una tarea cerrada");
        }
    }

    /**
     * @see modelo.Colaborador#reanudarTarea(modelo.Tarea)
     */
    @Test
    public void testReanudarTarea1()
    {
        try
        {
            this.fixture1.colab.reanudarTarea(this.fixture1.tareas.get(0));
            fail("No se verifica si la tarea esta abierta");   
        }
        catch(final Exception e)
        {
            fail("Lanza excepcion al reanudar una tarea abierta");
        }
    }
    
    /**
     * @see modelo.Colaborador#reanudarTarea(modelo.Tarea)
     */
    @Test
    public void testReanudarTarea2()
    {
        try
        {
            this.fixture1.colab2.reanudarTarea(this.fixture1.tareas.get(2));
            assertTrue("La tarea no se reanudo",fixture1.tareas.get(2).getEstado().devolverestado().equalsIgnoreCase("abierta"));
        }
        catch(final Exception e)
        {
            fail("Error inesperado");
        }
    }
    
    /**
     * @see modelo.Colaborador#reanudarTarea(modelo.Tarea)
     */
    @Test
    public void testReanudarTarea3()
    {
        try
        {
            this.fixture1.colab.reanudarTarea(fixture1.tareas.get(3));
            fail("No se verifica que la tarea este cerrada");
        }
        catch(final Exception e)
        {
            fail("Al abrir una tarea cerrada se lanza excepcion");
        }
    }
    
    /**
     * @see modelo.Colaborador#reanudarTarea(modelo.Tarea)
     */
    @Test
    public void testReanudarTarea4()
    {
        try
        {
            this.fixture1.colab.reanudarTarea(null);
            fail("No se verifica que la tarea sea nula");
        }
        catch(final Exception e)
        {
            fail("Al abrir una tarea nula se lanza excepcion");
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasIntervalo(java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasIntervalo1()
    {
        try
        {
            Colaborador col1=this.fixture1.colab2;
            //Colaborador col1=this.fixture1.bdd.getColaboradores().get(0);
            Date d1I= new Date(118,9,1);
            Date d2I= new Date();
            Date d1=new Date(118,10,1);
            Date d2=new Date();
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado=col1.solicitarITareasIntervalo(d1I, d2I);
            String mensaje= /*"Cliente  |  Tarea de servicio  | Total horas\n" +*/ "Jeremias" + " " + "Procesar" + " " + horas + "\n";
            assertEquals("Informe incorrecto",mensaje,resultado);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeColaboradorIntervalo dispara excepcion");
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasIntervalo(java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasIntervalo2()
    {
        try
        {
            Colaborador col1= new Colaborador("Peter","peter@gmail.com","111111111","111A","1234","Colaborador");
            Date d1= new Date(118,10,1);
            Date d2= new Date(118,10,20);
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado= col1.solicitarITareasIntervalo(d1, d2);
            //String mensaje= "Cliente  |  Tarea de servicio  | Total horas\n";
            String mensaje="";
            assertEquals("Informe incorrecto",resultado,mensaje);
        }
        catch( final Exception e )
        {
            //fail("Dispara excepcion al utilizar un usuario no registrado");
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasIntervalo(java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasIntervalo3()
    {
        try
        {
            Colaborador col1=this.fixture1.colab2;
            Date d1I= new Date(118,10,12);
            Date d2I= new Date(118,10,20);
            Date d1= new Date(118,10,10);
            Date d2= new Date(118,10,1);
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado=col1.solicitarITareasIntervalo(d1I, d2I);
            //String mensaje= "Cliente  |  Tarea de servicio  | Total horas\n";
            String mensaje="";
            assertEquals("Informe incorrecto",mensaje,resultado);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeColaboradorIntervalo dispara excepcion");
        }
    }

    /**
     * @see modelo.Colaborador#solicitarITareasIntervaloCliente(modelo.Cliente,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasIntervaloCliente1()
    {
        try
        {
            Cliente c1=new Cliente("Claudio","Claudio@gmail.com","45678","54345","657828i","grupo3");
            Date d1=new Date(118,10,1);
            Date d2=new Date(118,10,20);
            Date d1I= new Date(118,9,12);
            Date d2I= new Date(118,10,21);
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado= fixture1.colab.solicitarITareasIntervaloCliente(c1, d1I, d2I,0);
            String mensaje=/* "Tarea de Servicio | Total horas  | Importe \n" + */"Transportar"+ " " + horas + " " + 1500 + "\n";
            assertEquals("Informe incorrecto",mensaje,resultado);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeCliente dispara excepcion");
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasIntervaloCliente(modelo.Cliente,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasIntervaloCliente2()
    {
        try
        {
            Cliente c2= new Cliente("Adolfo","adolfo@gmail.com","345678","655432","4r3r21","grupo2");
            Date d1= new Date(118,10,1);
            Date d2= new Date(118,10,30);
            Date d1I= new Date(118,9,12);
            Date d2I= new Date(118,11,20);
            long horas= (d2.getTime() - d1.getTime())/3600000;
            long costo = (long) (horas * 89);
            String resultado= this.fixture1.colab.solicitarITareasIntervaloCliente(c2, d1I, d2I,0);
            String mensaje= /*"Tarea de Servicio | Total horas  | Importe \n" +*/ "Pasear"+ " " + horas + " " + costo + "\n";
            assertEquals("Informe incorrecto",resultado,mensaje);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeCliente dispara excepcion");
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasIntervaloCliente(modelo.Cliente,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasIntervaloCliente3()
    {
        try
        {
            Cliente c1= new Cliente("Peter","peter@gmail.com","4324234","2121321312","123","grupo1");
            Date d1= new Date(118,10,1);
            Date d2= new Date(118,10,20);
            String resultado= this.fixture1.colab.solicitarITareasIntervaloCliente(c1, d1, d2,0);
            //String mensaje= "Tarea de Servicio | Total horas  | Importe \n";
            String mensaje="";
            assertEquals("Informe incorrecto",resultado,mensaje);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeCliente dispara excepcion");
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasIntervaloCliente(modelo.Cliente,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasIntervaloCliente4()
    {
        try
        {
            Cliente c1=new Cliente("Lucrecia","Lucrecia@gmail.com","345234","434231","524455","grupo1");
            Date d1= new Date(118,9,1);
            Date d2= new Date(118,10,20);
            String resultado=this.fixture1.colab.solicitarITareasIntervaloCliente(c1, d1, d2,0);
            //String mensaje= "Tarea de Servicio | Total horas  | Importe \n";
            String mensaje="";
            assertEquals("Informe incorrecto",resultado,mensaje);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeCliente dispara excepcion");
        }
    }

    /**
     * @see modelo.Colaborador#solicitarITareasEstadoIntervalo(String,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasEstadoIntervalo1()
    {
        try
        {
            String resp = "Cliente  |  Tarea de Servicio  |  Inicio  |  Estado  |  Horas Acumuladas\n";
            Cliente cli=this.fixture1.bdd.getClientes().get(0);
            Date d1I= new Date(118,9,1);
            Date d2I= new Date(118,10,20);
            Date d1=new Date(118,10,1);
            Date d2=new Date(118,10,10);
            String mensaje=this.fixture1.colab1.solicitarITareasEstadoIntervalo("cerrado",d1I,d2I);
            long horas=(d2.getTime()-d1.getTime())/3600000;
            resp+="Juan"+" "+"Limpiar"+" "+d1.getTime()+" "+"cerrado"+" "+horas;
            assertEquals("Informe incorrecto",resp,mensaje);
        }
        catch(final Exception e)
        {
            fail("SolicitarITareasEstadoIntervalo dispara excepci�n (error inesperado)");
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasEstadoIntervalo(String,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasEstadoIntervalo2()
    {
        try
        {
            Colaborador col=new Colaborador();
            String resp = "Cliente  |  Tarea de Servicio  |  Inicio  |  Estado  |  Horas Acumuladas\n";
            Date d1I= new Date(118,10,9);
            Date d2I= new Date(118,10,20);
            Date d1=new Date(118,10,1);
            Date d2=new Date(118,10,10);
            String mensaje=col.solicitarITareasEstadoIntervalo("cerrada", d1I, d2I);
            long horas=(d2.getTime()-d1.getTime())/3600000;
            assertEquals("Informe incorrecto",resp,mensaje);
        }
        catch(final Exception e)
        {
            fail("SolicitarITareasEstadoIntervalo dispara excepci�n");
        }
    }
        
    /**
     * @see modelo.Colaborador#solicitarITareasEstadoIntervalo(String,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasEstadoIntervalo6()
    {
        try
        {
            String resp = "Cliente  |  Tarea de Servicio  |  Inicio  |  Estado  |  Horas Acumuladas\n";
            Date d1I= new Date(118,9,1);
            Date d2I= new Date(118,10,20);
            Date d1=new Date(118,10,1);
            Date d2=new Date(118,10,10);
            String mensaje=this.fixture1.colab1.solicitarITareasEstadoIntervalo("", d1I, d2I);
            long horas=(d2.getTime()-d1.getTime())/3600000;
            //resp+=this.fixture1.tareas.get(3).getCliente()+" "+fixture1.tareas.get(3).getServicio().getDescripcion()+" "+fixture1.tareas.get(3).getFechainicio()+" "+fixture1.tareas.get(3).getEstado().devolverestado()+" ";
            assertEquals("Informe incorrecto",resp,mensaje);
            fail("No lanza excepcion por estado vacio");
        }
        catch(final Exception e)
        {
            fail("SolicitarITareasEstadoIntervalo dispara excepci�n por estado vacio");
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasEnCurso()
     */
    @Test
    public void testSolicitarITareasEnCurso1()
    {
        try
        {
            Date d1= new Date(118,10,20);
            Date d2= new Date();
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado=this.fixture1.colab2.solicitarITareasEnCurso();
            String mensaje= "Guillermo" + " " + "Jeremias" + " " + "Procesar" + " " + d1 + " " + "pausada"+ " " +horas+ "\n";
            assertEquals("Informe incorrecto",mensaje,resultado);
        }
        catch( final Exception e )
        {
            fail("solicitarTareasEnCursoColaboradores dispara excepcion");
        }
    }
}