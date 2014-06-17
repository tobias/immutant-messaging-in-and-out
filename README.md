# Coordinating between two apps via messaging inside and outside of WildFly

# Usage

First, run the two apps outside of WildFly to see them
communicate. When outside of WF, `msg1` manages the HornetQ instance,
and `msg2` connects remotely:

    cd msg1
    lein run

In another shell:

    cd msg2
    lein run

You should see "GOT 2" as the output from `msg2`. `msg1` sets up an
`inc` responder, and `msg2` makes a `request` call with `1`.

Now, run each in WF. Deploy `msg1` first:

    cd msg1
    lein immutant deploy path/to/wildfly-8.1.0.Final

then `msg2`:

    cd msg2
    lein immutant deploy path/to/wildfly-8.1.0.Final


The logic around queue creation in `msg2/src/msg2/core.clj` controls
whether a remote connection (outside of WF) or a local one (inside) is
made.

## License

Copyright © 2014 Toby Crawley

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
