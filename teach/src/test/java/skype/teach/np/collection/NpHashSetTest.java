package skype.teach.np.collection;

/**
 * @author NPrilepa
 */
public class NpHashSetTest extends NpSetTest {
    @Override
    protected <T> NpSet<T> createInstance() {
        return new NpHashSet<T>();
    }
}
