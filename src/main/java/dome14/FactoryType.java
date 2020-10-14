package dome14;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum  FactoryType {

    REGISTER(RegisterHandler.class),

    SIGN_IN(RegisterHandler.class);

    private final Class<? extends Handler  > handler;

    public static void main(String[] args) {
        Class<? super RegisterHandler> handler= Handler.class;
        String name = handler.getName();
        System.out.println(name);
    }
}
