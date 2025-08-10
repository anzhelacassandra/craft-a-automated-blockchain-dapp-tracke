import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import io.vertx.core.Vertx
import io.vertx.kotlin.coredeploymentoptions
import kotlinx.coroutines.*
import org.bouncycastle.jce.provider.BouncyCastleProvider
import java.security.Security
import java.util.*

object Config {
    val vertx = Vertx.vertx()

    init {
        Security.addProvider(BouncyCastleProvider())
    }

    val deploymentOptions = coreDeploymentOptions {
        // Set up deployment options for our Vert.x application
        workerPoolSize = 20
        workerExecutorFallback = true
        blockingWorker = true
    }

    val blockchainConfig = BlockchainConfig(
        url = "https://mainnet.infura.io/v3/YOUR_PROJECT_ID",
        chainId = 1,
        rpcTimeout = 30000
    )

    val dappConfig = DappConfig(
        name = "My Automated Blockchain Dapp Tracker",
        description = "A Kotlin-based automated blockchain Dapp tracker",
        version = "1.0.0"
    )

    val web3jConfig = Web3jConfig(
        web3jUrl = "https://mainnet.infura.io/v3/YOUR_PROJECT_ID",
        web3jContractAddress = "0x...",
        web3jContractABI = "...",
        gasPrice = 20,
        gasLimit = 30000
    )
}

data class BlockchainConfig(
    val url: String,
    val chainId: Int,
    val rpcTimeout: Int
)

data class DappConfig(
    val name: String,
    val description: String,
    val version: String
)

data class Web3jConfig(
    val web3jUrl: String,
    val web3jContractAddress: String,
    val web3jContractABI: String,
    val gasPrice: Int,
    val gasLimit: Int
)