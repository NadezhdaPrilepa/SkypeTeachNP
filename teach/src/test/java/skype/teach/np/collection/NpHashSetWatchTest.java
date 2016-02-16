package skype.teach.np.collection;

/**
 * @author NPrilepa
 */
public class NpHashSetWatchTest extends NpSetWithWatchTest {
    @Override
    protected <T> NpSet<T> createInstance() {
        return new NpHashSet<T>();
    }
}
