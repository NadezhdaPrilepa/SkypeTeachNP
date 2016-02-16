package skype.teach.np.collection;

import java.util.LinkedList;

/**
 * @author NPrilepa
 */
public class NpAdapterLinkedListWatchTest extends NpListWithWatchTest {
    @Override
    protected <T> NpList<T> createInstance() {
        return new NpAdapterList<T>(new LinkedList<T>());
    }
}
