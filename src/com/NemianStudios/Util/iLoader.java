/*
 * iLoader.java
 *
 * Created on February 27, 2008, 10:36 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.NemianStudios.Util;

import com.NemianStudios.Base.customDataTypes.*;

/**
 *
 * @author RodgersGB
 */
public interface iLoader {
    public Model load(String path) throws ModelLoadException;
}
