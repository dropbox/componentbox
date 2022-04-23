import Link from "@docusaurus/Link";
import useDocusaurusContext from "@docusaurus/useDocusaurusContext";
import HomepageFeatures from "@site/src/components/HomepageFeatures";
import Layout from "@theme/Layout";
import clsx from "clsx";
import React from "react";
import { Prism } from "react-syntax-highlighter";
import dracula from "react-syntax-highlighter/src/styles/prism/duotone-light";
import cover from "../../static/img/cover.png";
import { simpleFragment, simpleScreen, activity } from "../../static/snippets";
import Divider from "../components/Divider";
import HomepageBottomCta from "../components/HomepageBottomCta";
import HomepageTopBanner from "../components/HomepageTopBanner";
import styles from "./index.module.css";

function HomepageHeader() {
  const { siteConfig } = useDocusaurusContext();
  return (
    <header
      className={clsx(styles.heroBanner)}
      style={{
        fontFamily: "Space Grotesk",
        backgroundImage: `url(${cover})`,
        height: 400,
        backgroundPosition: "center",
      }}
    >
      <div
        className="container"
        style={{
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
        }}
      >
        <h1
          className="hero__title"
          style={{
            fontFamily: "Space Grotesk",
            fontSize: 56,
            color: "#3A7AFF",
          }}
        >
          {siteConfig.title}
        </h1>
        <p className="hero__subtitle" style={{ color: "#ffffff" }}>
          {siteConfig.tagline}
        </p>

        <div style={{ display: "flex", flexDirection: "row" }}>
          <div
            style={{
              borderRadius: 0,
              padding: 12,
              backgroundColor: "#3a7aff",
              display: "flex",
              flexDirection: "row",
              justifyContent: "center",
              alignItems: "center",
              marginRight: 16,
            }}
          >
            <Link
              to="/docs"
              style={{ color: "#282C34", fontWeight: "bold", fontSize: 24 }}
            >
              Get Started
            </Link>
          </div>

          <div
            style={{
              borderRadius: 0,
              padding: 12,
              display: "flex",
              flexDirection: "row",
              justifyContent: "center",
              alignItems: "center",
            }}
          >
            <Link
              to="/docs"
              style={{ color: "#3a7aff", fontWeight: "bold", fontSize: 24 }}
            >
              Take the Tutorial
            </Link>
          </div>
        </div>
      </div>
    </header>
  );
}

export default function Home() {
  const { siteConfig } = useDocusaurusContext();

  return (
    <div
      style={{
        display: "flex",
        flexDirection: "column",
        justifyContent: "space-between",
        height: "100%",
      }}
    >
      <HomepageTopBanner />

      <Layout>
        <HomepageHeader />
        <main>
          <HomepageFeatures />
          <Divider />

          <div
            style={{
              width: "100%",
              display: "flex",
              flexDirection: "row",
              justifyContent: "center",
            }}
          >
            <div style={{ width: 500 }}>
              <Prism language="kotlin" style={dracula}>
                {activity}
              </Prism>
            </div>
          </div>

          <div
            style={{
              width: "100%",
              display: "flex",
              flexDirection: "row",
              justifyContent: "center",
            }}
          >
            <div style={{ width: 500 }}>
              <Prism language="kotlin" style={dracula}>
                {simpleScreen}
              </Prism>
            </div>
          </div>
        </main>
        <HomepageBottomCta />
      </Layout>
    </div>
  );
}
