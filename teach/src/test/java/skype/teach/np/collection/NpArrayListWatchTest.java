package skype.teach.np.collection;

/**
 * @author NPrilepa
 */
public class NpArrayListWatchTest extends NpListWithWatchTest {
    @Override
    protected <T> NpList<T> createInstance() {
        return new NpArrayList<T>();
    }
}
