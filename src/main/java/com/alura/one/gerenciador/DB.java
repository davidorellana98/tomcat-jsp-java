package com.alura.one.gerenciador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DB {

    private static List<Empresa> listaEmpresas = new ArrayList<>();
    private static Integer llaveSecuencial = 1;

    static {
        Empresa empresa = new Empresa();
        empresa.setId(DB.llaveSecuencial++);
        empresa.setNombre("Alura");
        Empresa empresa2 = new Empresa();
        empresa2.setId(DB.llaveSecuencial++);
        empresa2.setNombre("Oracle");
        listaEmpresas.add(empresa);
        listaEmpresas.add(empresa2);
    }

    public void agregarEmpresa(Empresa empresa) {
        empresa.setId(DB.llaveSecuencial++);
        DB.listaEmpresas.add(empresa);
    }

    public List<Empresa> getListaEmpresas() {
        return DB.listaEmpresas;
    }

    public void elimarEmpresa(Integer id) {

        Iterator<Empresa> it = listaEmpresas.iterator();
        while (it.hasNext()) {
            Empresa emp = it.next();
            if (emp.getId() == id) {
                it.remove();
            }
        }
        /* No es optimo utilizar un for, ya que despues de elimnar otro
        indice, este ya no lo reconoce.
        for (Empresa empresa: listaEmpresas) {
            if (empresa.getId() == id) {
                listaEmpresas.remove(empresa);
            }
        }*/
    }

    public Empresa buscarEmpresaPorId(Integer id) {
        for (Empresa empresa: listaEmpresas) {
            if (empresa.getId() == id) {
                return empresa;
            }
        }
        return null;
    }
}
