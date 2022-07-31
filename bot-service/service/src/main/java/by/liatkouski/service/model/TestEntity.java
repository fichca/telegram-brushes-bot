package by.liatkouski.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TestEntity {
    private int x;
    private int y;
    private String string;
    private TestTestEntity testTestEntity = new TestTestEntity(1, 2222);
    private static String string1;

    public TestEntity(int x, int y, String string) {
        this.x = x;
        this.y = y;
        this.string = string;
    }

    @Data
    @AllArgsConstructor
    public class TestTestEntity {
        private int x;
        private int y;

        public String get() {
            return null;
        }
    }
}
