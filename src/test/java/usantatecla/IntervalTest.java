package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntervalTest {

    private Point left = new Point(-2.2);
    private Point right = new Point(4.4);
    private IntervalBuilder intervalBuilder;

    @BeforeEach
    public void before() {
        this.left = new Point(-2.2);
        this.right = new Point(4.4);
        this.intervalBuilder = new IntervalBuilder();
    }

    @Test
    public void givenIntervaOpenOpenlwhenIncludeWithIncludedValueThenTrue() {
        Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
        assertFalse(interval.include(left.getLess()));
        assertFalse(interval.include(left.getEquals()));
        assertTrue(interval.include(left.getGreater()));
        assertTrue(interval.include(right.getLess()));
        assertFalse(interval.include(right.getEquals()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    public void givenIntervaOpenOpenlwhenInc3ludeWithIncludedValueThenTrue() {
        Interval interval = this.intervalBuilder.closed(left.getEquals()).open(right.getEquals()).build();
        assertFalse(interval.include(left.getLess()));
        assertTrue(interval.include(left.getEquals()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertFalse(interval.include(right.getEquals()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    public void givenIntervaOpenOpenlwhenIncludeWit3hIncludedValueThenTrue() {
        Interval interval = this.intervalBuilder.open(left.getEquals()).closed(right.getEquals()).build();
        assertFalse(interval.include(left.getLess()));
        assertFalse(interval.include(left.getEquals()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertTrue(interval.include(right.getEquals()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    public void givenIntervaOpenOpenlwhenIncludeWithInclude5dValueThenTrue() {
        Interval interval = this.intervalBuilder.closed(left.getEquals()).closed(right.getEquals()).build();
        assertFalse(interval.include(left.getLess()));
        assertTrue(interval.include(left.getEquals()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertTrue(interval.include(right.getEquals()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    public void givenOpenIntervalIntervalWhenIntersectionWithItSelfThenTrue() {
        Interval interval = new IntervalBuilder().open(left.getEquals()).open(left.getGreater()).build();
        assertTrue(interval.intersection(interval));
    }

    @Test
    public void givenOpenIntervalWhenIntersectionWithOtherOpenIntervalThenTrue() {
        Interval first = new IntervalBuilder().open(left.getLess()).open(left.getGreater()).build();
        Interval second = new IntervalBuilder().open(left.getEquals()).open(left.getGreater()).build();
        assertTrue(first.intersection(second));
        assertTrue(second.intersection(first));
    }

    @Test
    public void givenOpenIntervalWhenIntersectionWithOtherOpenIntervalThenFalse() {
        Interval first = new IntervalBuilder().open(left.getLess()).open(left.getEquals()).build();
        Interval second = new IntervalBuilder().open(left.getEquals()).open(left.getGreater()).build();
        assertFalse(first.intersection(second));
        assertFalse(second.intersection(first));
    }

    @Test
    public void givenCloseIntervalWhenIntersectionWithOtherCloseIntervalThenTrue() {
        Interval first = new IntervalBuilder().closed(left.getLess()).closed(left.getEquals()).build();
        Interval second = new IntervalBuilder().closed(left.getEquals()).closed(left.getGreater()).build();
        assertTrue(first.intersection(second));
        assertTrue(second.intersection(first));
    }

    @Test
    public void givenCloseIntervalWhenIntersectionWithOtherCloseIntervalThenFalse() {
        Interval first = new IntervalBuilder().closed(left.getLess()).closed(left.getEquals()).build();
        Interval second = new IntervalBuilder().closed(right.getEquals()).closed(right.getGreater()).build();
        assertFalse(first.intersection(second));
        assertFalse(second.intersection(first));
    }

    @Test
    public void givenCloseIntervalWhenIntersectionWithOpenIntervalThenTrue() {
        Interval first = new IntervalBuilder().closed(left.getLess()).closed(right.getEquals()).build();
        Interval second = new IntervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
        assertTrue(first.intersection(second));
    }

    @Test
    public void givenCloseIntervalWhenIntersectionWithOpenIntervalThenFalse() {
        Interval first = new IntervalBuilder().closed(right.getLess()).closed(right.getEquals()).build();
        Interval second = new IntervalBuilder().open(right.getEquals()).open(right.getGreater()).build();
        assertFalse(first.intersection(second));
    }

    @Test
    public void givenOpenIntervalWhenIntersectionWithCloseIntervalThenTrue() {
        Interval first = new IntervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
        Interval second = new IntervalBuilder().closed(left.getLess()).closed(right.getEquals()).build();
        assertTrue(first.intersection(second));
    }

    @Test
    public void givenOpenIntervalWhenIntersectionWithCloseIntervalThenFalse() {
        Interval first = new IntervalBuilder().open(right.getEquals()).open(right.getGreater()).build();
        Interval second = new IntervalBuilder().closed(right.getLess()).closed(right.getEquals()).build();
        assertFalse(first.intersection(second));
    }

}
