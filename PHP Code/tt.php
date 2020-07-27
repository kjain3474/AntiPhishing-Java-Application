
<?php
/**
 * The IP-address to be looked up.
 * @param string $ip
 */
function dnsbllookup($ip)
{
    // Add your preferred list of DNSBL's
    $dnsbl_lookup = [
        "dnsbl-1.uceprotect.net",
        "dnsbl-2.uceprotect.net",
        "dnsbl-3.uceprotect.net",
        "dnsbl.dronebl.org",
        "dnsbl.sorbs.net",
        "zen.spamhaus.org",
        "bl.spamcop.net",
        "list.dsbl.org",
        "sbl.spamhaus.org",
        "xbl.spamhaus.org"
    ];
    $listed = "";
    if ($ip) {
        $reverse_ip = implode(".", array_reverse(explode(".", $ip)));
        //echo "ip ".$ip;
        //echo "<br> reverse_ip ; ".$reverse_ip;
        foreach ($dnsbl_lookup as $host) {
            if (checkdnsrr($reverse_ip . "." . $host . ".", "A")) {
                $listed .= $reverse_ip . '.' . $host . ' <font color="red">Listed</font><br />';
            }
        }
    }
    if (empty($listed)) {
        echo 'record was not found';
    } else {
        echo "listed";
    }
}
if (isset($_GET['ip']) && $_GET['ip'] != null) {
    $ip = $_GET['ip'];
    if (filter_var($ip, FILTER_VALIDATE_IP)) {
        echo dnsbllookup($ip);
    } else {
        echo "Please enter a valid IP";
    }
}
?>
