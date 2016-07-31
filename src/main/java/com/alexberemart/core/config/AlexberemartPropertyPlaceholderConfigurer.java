package com.alexberemart.core.config;

import com.alexberemart.core.util.StringUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

public class AlexberemartPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    @Override
    protected String resolvePlaceholder(String placeholder, Properties props) {
        String result = props.getProperty(placeholder);

        if (result != null) {
            return result;
        }

        final String environment = resolveSystemProperty("environment");

        if(StringUtils.isNotBlank(environment)) {
            final String profilePlaceholder = new StringBuilder().append(environment).append(".").append(placeholder).toString();
            result = props.getProperty(profilePlaceholder);

            if (result != null) {
                return result;
            }
        }

        final String wildcardPlaceholder = new StringBuilder().append("*").append(".").append(placeholder).toString();
        result = props.getProperty(wildcardPlaceholder);

        return result;
    }
}
