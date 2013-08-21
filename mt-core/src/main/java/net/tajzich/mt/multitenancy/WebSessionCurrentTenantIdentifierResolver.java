package net.tajzich.mt.multitenancy;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;

/**
 * Created with IntelliJ IDEA.
 * User: vtajzich
 * Date: 8/21/13
 */
public class WebSessionCurrentTenantIdentifierResolver implements CurrentTenantIdentifierResolver {

    private static final Logger LOG = LoggerFactory.getLogger(WebSessionCurrentTenantIdentifierResolver.class);

    @Autowired
    private HttpServletRequest request;

    @Override
    public String resolveCurrentTenantIdentifier() {

        String tenantId = request.getHeader("X-TenantId");

        LOG.info(MessageFormat.format("Found TenantId=\"{0}\"", tenantId));

        return tenantId;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return false;
    }
}
