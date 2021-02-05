package com.doctor_ew.pojo_generator;

import static org.junit.Assert.assertTrue;

import com.doctor_ew.pojo_generator.model.TestPerson;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class GeneratePojoTest
{
    /**
     * Rigorous Test :-)
     */

    private GeneratePojo generatePojo = new GeneratePojo();

    @Test
    public void testGenerateNewInstance() {
        TestPerson person = new TestPerson();
        person = (TestPerson)generatePojo.generateNewInstance(person);
        System.out.println(person);
    }
}
