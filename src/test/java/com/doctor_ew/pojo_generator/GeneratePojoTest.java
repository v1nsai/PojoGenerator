package com.doctor_ew.pojo_generator;

import com.doctor_ew.pojo_generator.model.Person;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

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
    public void testDoesAnythingActuallyHappen() {
        Person person = new Person();
        person = (Person)generatePojo.generateNewInstance(person);
        assertTrue(person.getFirstName() != null);
    }

    @Test
    public void testNestedObjects() {
        Person person = new Person();
        person = (Person) generatePojo.generateNewInstance(person);
        assertTrue(person.getAddress() != null);
    }

    @Test
    public void testList() {
        Person person = new Person();
        person = (Person) generatePojo.generateNewInstance(person);
        assertTrue(person.getPreviousAddresses().size() > 0);
    }
}
