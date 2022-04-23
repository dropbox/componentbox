import Link from "@docusaurus/Link";
import React from "react";

export default function HomepageBottomCta() {
  return (
    <div
      style={{
        display: "flex",
        flexDirection: "row",
        width: "100%",
        justifyContent: "center",
        backgroundColor: "#282C34",
        padding: 24,
      }}
    >
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
  );
}
