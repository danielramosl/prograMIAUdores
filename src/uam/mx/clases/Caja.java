/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.mx.clases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author prograMIAUdores
 */
public abstract class Caja {
    protected float total;

    public Caja(float total) {
        this.total = total;
    }
}