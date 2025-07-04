package com.agent;
import com.agent.web.AuthorizationConsentController;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.TypeReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.thymeleaf.expression.Lists;

import java.util.Arrays;
@ComponentScan(basePackages = "com.agent.config")
@ComponentScan(basePackages = "com.agent.web")
@ComponentScan(basePackages = "com.agent.authentication")
@ComponentScan(basePackages = "com.agent.federation")
@ImportRuntimeHints(IdentifyServerApplication.AuthorizationServerApplicationRuntimeHintsRegistrar.class)

@SpringBootApplication
public class IdentifyServerApplication {

	static class AuthorizationServerApplicationRuntimeHintsRegistrar implements RuntimeHintsRegistrar {
		@Override
		public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
			hints.reflection().registerTypes(
					Arrays.asList(
							TypeReference.of(AuthorizationConsentController.ScopeWithDescription.class),
							TypeReference.of(Lists.class)
					), builder ->
							builder.withMembers(MemberCategory.DECLARED_FIELDS,
									MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.INVOKE_DECLARED_METHODS)
			);
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(IdentifyServerApplication.class, args);
	}

}
