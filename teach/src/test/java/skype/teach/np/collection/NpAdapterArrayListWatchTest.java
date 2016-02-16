package skype.teach.np.collection;

import java.util.ArrayList;

/**
 * @author NPrilepa
 */
public class NpAdapterArrayListWatchTest extends NpListWithWatchTest {
    @Override
    protected <T> NpList<T> createInstance() {
        return new NpAdapterList<T>(new ArrayList<T>());
    }

}
