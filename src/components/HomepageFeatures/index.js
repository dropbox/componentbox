import React from 'react';
import clsx from 'clsx';
import styles from './styles.module.css';

// Easy to use
// Declarative
// Powered by Zipline
// Increased velocity of experimentation
// Learn once, write anywhere
// Native

const FeatureList = [


    {
        title: 'Material Component-Based',
        Svg: require('@site/static/img/tools.svg').default,
        description: (
            <>
                A Kotlin multiplatform library for building dynamic server-driven UI
            </>
        ),
    },

    {
        title: 'Interoperable',
        Svg: require('@site/static/img/interoperability.svg').default,
        description: (
            <>
                A Kotlin multiplatform library for building dynamic server-driven UI
            </>
        ),
    },

    {
        title: 'Dynamic',
        Svg: require('@site/static/img/celebration_spin.svg').default,
        description: (
            <>
                A Kotlin multiplatform library for building dynamic server-driven UI
            </>
        ),
    },

    {
        title: 'What You See Is What You Get',
        Svg: require('@site/static/img/devices_couch.svg').default,
        description: (
            <>
                A Kotlin multiplatform library for building dynamic server-driven UI
            </>
        ),
    },
];

function Feature({Svg, title, description}) {
    return (
        <div className={clsx('col col--3')}>
            <div className="text--center">
                <Svg className={styles.featureSvg} role="img"/>
            </div>
            <div className="text--center padding-horiz--md">
                <h3>{title}</h3>
                <p>{description}</p>
            </div>
        </div>
    );
}

export default function HomepageFeatures() {
    return (
        <section className={styles.features}>
            <div className="container">
                <div className="row">
                    {FeatureList.map((props, idx) => (
                        <Feature key={idx} {...props} />
                    ))}
                </div>
            </div>
        </section>
    );
}
