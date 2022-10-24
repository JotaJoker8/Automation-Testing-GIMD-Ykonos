package es.sescam.automation.testing.gimd.ykonos.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

public class OrderedRunner extends BlockJUnit4ClassRunner {

	public OrderedRunner(Class<?> clazz) throws InitializationError {
		super(clazz);
	}

	@Override
	protected List<FrameworkMethod> computeTestMethods() {

		List<FrameworkMethod> list = super.computeTestMethods();
		List<FrameworkMethod> copy = new ArrayList<>(list);

		copy.sort((FrameworkMethod f1, FrameworkMethod f2) -> {
			Order o1 = f1.getAnnotation(Order.class);
			Order o2 = f2.getAnnotation(Order.class);

			if (Objects.isNull(o1) || Objects.isNull(o2)) {
				return -1;
			}

			return o1.value() - o2.value();
		});

		return copy;

	}

}
