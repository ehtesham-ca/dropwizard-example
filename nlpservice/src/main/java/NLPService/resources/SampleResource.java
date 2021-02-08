package NLPService.resources;

import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import io.dropwizard.jersey.caching.CacheControl;
import io.dropwizard.jersey.params.DateTimeParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import NLPService.api.*;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Path("/sample-endpoint")
@Produces(MediaType.APPLICATION_JSON)
public class SampleResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleResource.class);

    private final AtomicLong counter;

    public SampleResource() {
        this.counter = new AtomicLong();
    }

    @GET
    @Timed(name = "get-requests-timed")
    @Metered(name = "get-requests-metered")
    @CacheControl(maxAge = 1, maxAgeUnit = TimeUnit.DAYS)
    public SampleResponseObj sampleGet(@QueryParam("name") Optional<String> name) {
        return new SampleResponseObj(counter.incrementAndGet(), name.orElse("Test"));
    }

    @POST
    public void samplePost(SampleRequestObj reqObj) {
        LOGGER.info("Received a saying: {}", reqObj);
    }

    @GET
    @Path("/date")
    @Produces(MediaType.TEXT_PLAIN)
    public String receiveDate(@QueryParam("date") Optional<DateTimeParam> dateTimeParam) {
        if (dateTimeParam.isPresent()) {
            final DateTimeParam actualDateTimeParam = dateTimeParam.get();
            LOGGER.info("Received a date: {}", actualDateTimeParam);
            return actualDateTimeParam.get().toString();
        } else {
            LOGGER.warn("No received date");
            return null;
        }
    }
}
