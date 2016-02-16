package skype.teach.np.collection;

/**
 * @author NPrilepa
 */
public class NpLinkedListWatchTest extends NpListWithWatchTest {
    @Override
    protected <T> NpList<T> createInstance() {
        return new NpLinkedList<T>();
    }
}
