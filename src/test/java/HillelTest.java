/*
 * Copyright 2018 Orest Vasylyshyn.
 */
import com.orest.hilleltestapp.HillelTestApp;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Orest Vasylyshyn
 */
public class HillelTest {

	@Test
	public void collectionTest() throws Exception {
		Object arr[] = new Object[] {"Obj1", "Obj1", "Obj1"};
		List<Object> collection = new ArrayList<>();
		
		HillelTestApp.arrayToCollection(arr, collection);
		Assert.assertEquals(arr.length, collection.size());
	}
}
