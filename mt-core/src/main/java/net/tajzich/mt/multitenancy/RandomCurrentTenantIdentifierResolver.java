package net.tajzich.mt.multitenancy;

import org.apache.log4j.Logger;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

/**
 * Created with IntelliJ IDEA.
 * User: vtajzich
 * Date: 8/21/13
 */
public class RandomCurrentTenantIdentifierResolver implements CurrentTenantIdentifierResolver {

    private static final Logger LOG = Logger.getLogger(RandomCurrentTenantIdentifierResolver.class);

    @Override
    public String resolveCurrentTenantIdentifier() {

        if (Math.random() > 0.5d) {

            LOG.info("********** SELECTED: TENANT1");

            return "tenant1";
        } else {


            LOG.info("^^^^^^^^^^ SELECTED: TENANT2");

            return "tenant2";
        }
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return false;
    }
}
